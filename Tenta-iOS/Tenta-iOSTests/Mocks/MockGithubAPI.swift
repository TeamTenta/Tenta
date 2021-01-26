//
//  MockGithubAPI.swift
//  Tenta-iOSTests
//
//  Created by 김석호 on 2021/01/23.
//

import Foundation
@testable import Tenta_iOS

class MockGithubAPI: GithubAPI {
    private let completion: (URL) -> Void

    var token: String?
    var githubLoginURL = URL(string: "https://www.apple.com/")

    init() {
        self.completion = { _ in }
    }

    init(completion: @escaping (URL) -> Void) {
        self.completion = completion
    }

    func githubLoginCompletion(_ url: URL) {
        completion(url)
    }
}
