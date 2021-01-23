//
//  GithubAPI.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/18.
//

import Foundation
import AuthenticationServices

protocol GithubLogin {
    var githubLoginURL: URL? { get }

    func githubLoginCompletion(_ url: URL)
}

protocol GithubAPI: GithubLogin {
    var token: String? { get }
}

final class GithubAPIManager: GithubAPI, ObservableObject {
    @Published var token: String?
}

// MARK: Github Login
extension GithubAPIManager {
    var githubLoginURL: URL? {
        // TODO: 서버에 맞게 변경
        return URL(string: "https://www.apple.com/")
    }

    func githubLoginCompletion(_ url: URL) {
        guard url.absoluteString.starts(with: "tenta://"),
              let token = url.absoluteString.components(separatedBy: "tenta://").last.map({ String($0) }) else { return }
        self.token = token
    }
}
