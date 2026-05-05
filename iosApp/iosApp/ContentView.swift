import UIKit
import SwiftUI
import ComposeApp

private func configureOAuth() {
    let info = Bundle.main.infoDictionary
    OAuthConfig.shared.clientId = info?["QIITA_CLIENT_ID"] as? String ?? ""
    OAuthConfig.shared.clientSecret = info?["QIITA_CLIENT_SECRET"] as? String ?? ""
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        configureOAuth()
        return MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .ignoresSafeArea()
            .onOpenURL { url in
                OAuthRedirectState.shared.handleRedirectUrl(url: url.absoluteString)
            }
    }
}
