package explode.utils

import TConfig.Configuration
import TConfig.Property
import explode.utils.Config.ConfigPropertyDelegates.delegateBoolean
import explode.utils.Config.ConfigPropertyDelegates.delegateInt
import explode.utils.Config.ConfigPropertyDelegates.delegateString
import java.io.File
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Config(file: File) {

	private val config = Configuration(file)

	// GraphQL
	val port by config.get("graphql", "port", 10443).delegateInt()

	// DataProvider
	val mongoUrl by config.get("dataprovider", "mongo-connection-string", "mongodb://localhost:27017").delegateString()

	// Debugging
	val mongoLogging by config.get("debugging", "allow-mongodb-client-logging", false).delegateBoolean()
	val ktorLogging by config.get("debugging", "allow-ktor-server-logging", false).delegateBoolean()

	fun save() = config.save()

	private object ConfigPropertyDelegates {
		fun Property.delegateString() = object : ReadWriteProperty<Any?, String> {
			override fun getValue(thisRef: Any?, property: KProperty<*>): String {
				return this@delegateString.string
			}

			override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
				this@delegateString.setValue(value)
			}
		}

		fun Property.delegateBoolean() = object : ReadWriteProperty<Any?, Boolean> {
			override fun getValue(thisRef: Any?, property: KProperty<*>): Boolean {
				return this@delegateBoolean.boolean
			}

			override fun setValue(thisRef: Any?, property: KProperty<*>, value: Boolean) {
				this@delegateBoolean.setValue(value)
			}
		}

		fun Property.delegateInt() = object : ReadWriteProperty<Any?, Int> {
			override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
				return this@delegateInt.int
			}

			override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
				this@delegateInt.setValue(value)
			}
		}
	}

}