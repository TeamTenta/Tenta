//
//  ContentViewModel.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/23.
//

import Foundation

final class ContentViewModel: ObservableObject {
    private let githubAPI: GithubAPI

    init(_ githubAPI: GithubAPI) {
        self.githubAPI = githubAPI
    }

    var hasToken: Bool {
        !(githubAPI.token == nil)
    }

    var loginViewModel: LoginViewModel {
        LoginViewModel(githubAPI)
    }
}
