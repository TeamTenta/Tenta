//
//  LoginViewModel.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/20.
//

import Foundation

final class LoginViewModel: ObservableObject {
    private let githubLogin: GithubLogin
    let title = "Tenta"

    var url: URL? { githubLogin.githubLoginURL }
    var completion: (URL) -> Void { githubLogin.githubLoginCompletion }

    init(_ githubLogin: GithubLogin) {
        self.githubLogin = githubLogin
    }
}
