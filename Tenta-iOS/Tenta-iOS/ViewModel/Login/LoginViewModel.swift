//
//  LoginViewModel.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/20.
//

import Foundation

final class LoginViewModel: ObservableObject {
    let title = "Tenta"
}

// MARK: Github Login
extension LoginViewModel {
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

    func githubLoginCompletion(url: URL) {
        print(url)
    }
}
