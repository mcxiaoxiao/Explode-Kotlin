package explode.backend.ktor

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.scalars.IDValueUnboxer
import com.expediagroup.graphql.generator.toSchema
import explode.blow
import explode.blow.graphql.BlowService.mutation
import explode.blow.graphql.BlowService.query
import graphql.GraphQL

private val config = SchemaGeneratorConfig(
	supportedPackages = listOf("explode.blow.graphql.model"),
	hooks = CustomSchemaGeneratorHooks
)

val graphQLSchema = toSchema(config, listOf(blow.query), listOf(blow.mutation))

fun getGraphQLObject(): GraphQL = GraphQL.newGraphQL(graphQLSchema).valueUnboxer(IDValueUnboxer())
	.valueUnboxer(CustomSchemaGeneratorHooks.NNIntUnboxer).build()