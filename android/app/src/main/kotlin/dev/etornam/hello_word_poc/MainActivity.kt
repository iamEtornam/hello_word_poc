package dev.etornam.hello_word_poc

import androidx.annotation.NonNull
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity()
{
    private val CHANNEL = "hello_world_poc/app"

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->

            if(call.method == "hello_world_poc") {
                result.success(HelloWorld.message)
            } else {
                result.notImplemented()
            }
        }
    }
}
