import UIKit
import Flutter

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {
    GeneratedPluginRegistrant.register(with: self)
      
      let controller: FlutterViewController = self.window?.rootViewController as! FlutterViewController
      
      let methodChannel = FlutterMethodChannel(name: "hello_world_poc/app", binaryMessenger: controller as! FlutterBinaryMessenger)

      methodChannel.setMethodCallHandler({
          (call: FlutterMethodCall, result: FlutterResult) -> Void in

          if(call.method == "hello_world_poc") {
              result(HelloWorld.getMessage())
          }
          else {
              result(FlutterMethodNotImplemented)
          }
      })
    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }
}
