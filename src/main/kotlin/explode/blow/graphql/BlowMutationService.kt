package explode.blow.graphql

import com.expediagroup.graphql.server.operations.Mutation
import explode.blow.graphql.model.*
import graphql.schema.DataFetchingEnvironment

interface BlowMutationService : Mutation {

	suspend fun loginUser(username: String?, password: String?): UserModel

	suspend fun registerUser(username: String?, password: String?): UserModel

	suspend fun purchaseChart(env: DataFetchingEnvironment, chartId: String?): UserModel

	suspend fun exchangeSet(env: DataFetchingEnvironment, setId: String?): ExchangeSetModel

	suspend fun submitBeforeAssessment(env: DataFetchingEnvironment, assessmentGroupId: String?, medalLevel: Int?): BeforePlaySubmitModel

	suspend fun submitAfterAssessment(env: DataFetchingEnvironment, playRecords: List<PlayRecordInput?>?, randomId: String?): AfterAssessmentModel

	suspend fun submitBeforePlay(env: DataFetchingEnvironment, chartId: String?, PPCost: Int?, eventArgs: String?): BeforePlaySubmitModel

	suspend fun submitAfterPlay(env: DataFetchingEnvironment, randomId: String?, playRecord: PlayRecordInput?): AfterPlaySubmitModel
}