package com.example.billy.stockwatcher.model

import com.example.billy.stockwatcher.model.entities.*
import com.example.billy.stockwatcher.model.service.QuestionService
import com.example.billy.stockwatcher.model.service.UserService
import io.reactivex.Single
import io.reactivex.functions.Function3

class UserRepository(
        private val userService: UserService,
        private val questionService: QuestionService) {

    fun getUser(page: Int) = userService.getUsers(page)

    fun getDetails(userId: Long): Single<DetailsModel> {
        return Single.zip(
                userService.getQuestionsByUser(userId),
                getAnswers(userId),
                userService.getFavoritesByUser(userId),
                Function3<QuestionListModel, List<AnswerViewModel>, QuestionListModel, DetailsModel> { questions, answers, favorites ->
                    createDetailModel(questions, answers, favorites)
                }
        )
    }

    private fun getAnswers(userId: Long): Single<List<AnswerViewModel>> {
        return userService.getAnswersByUser(userId)
                .flatMap { answerList: AnswerListModel ->
                    mapAnswersToAnswerViewModels(answerList.items)
                }
    }

    private fun mapAnswersToAnswerViewModels(answers: List<Answer>): Single<List<AnswerViewModel>> {
        val processedAnswers = answers
                .filter { it.accepted }
                .take(3)

        val ids = processedAnswers
                .map { it.questionId.toString() }
                .joinToString(separator = ";")

        val questionListModel = questionService.getQuestionById(ids)

        return questionListModel
                .map { questionListModel: QuestionListModel? ->
                    addTitlesToAnswers(processedAnswers, questionListModel?.items ?: emptyList())
                }
    }

    private fun addTitlesToAnswers(answers: List<Answer>, question: List<Question>): List<AnswerViewModel> {
        return answers.map { (answerId, questionId, score, accepted) ->
            val question = question.find { it.questionId == questionId }
            AnswerViewModel(answerId, score, accepted, question?.title ?: "Unknown")
        }
    }

    private fun createDetailModel(questionModel: QuestionListModel, answerViewModel: List<AnswerViewModel>,
                                  favoritesModel: QuestionListModel): DetailsModel {
        val questions = questionModel.items.take(3)
        val favorites = favoritesModel.items.takeLast(3)
        return DetailsModel(questions, answerViewModel, favorites)
    }
}
