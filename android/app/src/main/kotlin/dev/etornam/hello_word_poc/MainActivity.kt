package dev.etornam.hello_word_poc

import io.flutter.embedding.android.FlutterActivity

class MainActivity: FlutterActivity()
{
    private val CHANNEL = "hello_world_poc/app"

    override fun configureFlutterEngine(@NonNull flutterEngine: FlutterEngine) {
        MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL).setMethodCallHandler {
                call, result ->

            if(call.method == "hello_world_poc") {
                result.success(HelloWorld.get())
            } else {
                result.notImplemented()
            }
        }
    }
}
