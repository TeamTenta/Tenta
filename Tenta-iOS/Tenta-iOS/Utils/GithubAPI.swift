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

final class GithubAPIManager {
    @Published var token: String?
}

// MARK: Github Login
extension GithubAPIManager: GithubLogin {
    var githubLoginURL: URL? {
        let clientID = ""
        let scope = "repo, user"
        let urlString = "https://github.com/login/oauth/authorize"
        var components = URLComponents(string: urlString)!
        components.queryItems = [
            URLQueryItem(name: "client_id", value: clientID),
            URLQueryItem(name: "scope", value: scope)
        ]
        return components.url
    }

    func githubLoginCompletion(_ url: URL) {
        guard url.absoluteString.starts(with: "tenta://"),
              let token = url.absoluteString.components(separatedBy: "tenta://").last.map({ String($0) }) else { return }
        self.token = token
    }
}
