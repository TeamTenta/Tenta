//
//  GithubLoginMock.swift
//  Tenta-iOSTests
//
//  Created by 김석호 on 2021/01/23.
//

import Foundation
@testable import Tenta_iOS

class MockGithubLogin: GithubLogin {
    private let completion: (URL) -> Void
    init(completion: @escaping (URL) -> Void) {
        self.completion = completion
    }

    var githubLoginURL = URL(string: "https://www.apple.com/")

    func githubLoginCompletion(_ url: URL) {
        completion(url)
    }
}
