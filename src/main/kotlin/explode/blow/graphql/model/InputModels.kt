package explode.blow.graphql.model

data class PlayRecordInput(
	val mod: PlayModInput?,
	val isAlive: Boolean?,
	val score: Int?,
	val perfect: Int?,
	val good: Int?,
	val miss: Int?
)

data class PlayModInput(
	val narrow: Double?,
	val speed: Double?,
	val isBleed: Boolean?,
	val isMirror: Boolean?
)