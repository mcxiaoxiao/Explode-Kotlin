package explode.blow.impl

import explode.blow.BlowMutationService
import explode.blow.BlowUtils.soudayo
import explode.dataprovider.model.*
import explode.dataprovider.provider.IBlowDataProvider
import graphql.schema.DataFetchingEnvironment

class BlowMutationServiceImpl(private val p: IBlowDataProvider) : BlowMutationService {

	override suspend fun loginUser(env: DataFetchingEnvironment, username: String?, password: String?): UserModel {
		return p.loginUser(username!!, password!!)
	}

	override suspend fun registerUser(env: DataFetchingEnvironment, username: String?, password: String?): UserModel {
		return p.registerUser(username!!, password!!)
	}

	override suspend fun purchaseChart(env: DataFetchingEnvironment, chartId: String?): UserModel {
		return p.getUser(env.soudayo, "")!! // TODO
	}

	override suspend fun exchangeSet(env: DataFetchingEnvironment, setId: String?): ExchangeSetModel {
		return p.buySet(env.soudayo, setId!!)
	}

	override suspend fun submitBeforeAssessment(
		env: DataFetchingEnvironment,
		assessmentGroupId: String?,
		medalLevel: Int?
	): BeforePlaySubmitModel {
		return p.submitBeforeAssessment(env.soudayo, assessmentGroupId!!, medalLevel!!)
	}

	override suspend fun submitAfterAssessment(
		env: DataFetchingEnvironment,
		playRecords: List<PlayRecordInput?>?,
		randomId: String?
	): AfterAssessmentModel {
		return p.submitAfterAssessment(env.soudayo, playRecords!!.filterNotNull(), randomId!!)
	}

	override suspend fun submitBeforePlay(
		env: DataFetchingEnvironment,
		chartId: String?,
		PPCost: Int?,
		eventArgs: String?
	): BeforePlaySubmitModel {
		return p.submitBeforePlay(env.soudayo, chartId!!, PPCost!!, eventArgs!!)
	}

	override suspend fun submitAfterPlay(
		env: DataFetchingEnvironment,
		randomId: String?,
		playRecord: PlayRecordInput?
	): AfterPlaySubmitModel {
		return p.submitAfterPlay(env.soudayo, playRecord!!, randomId!!)
	}
}