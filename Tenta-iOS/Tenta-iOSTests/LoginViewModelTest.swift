//
//  LoginViewModelTest.swift
//  Tenta-iOSTests
//
//  Created by 김석호 on 2021/01/23.
//

import XCTest
@testable import Tenta_iOS

class LoginViewModelTest: XCTestCase {
    func test_githubLoginCompletion_동작() {
        let exp = XCTestExpectation(description: "test completion")
        defer { wait(for: [exp], timeout: 5) }

        let mockCompletion: (URL) -> Void = { _ in
            exp.fulfill()
        }

        let viewModel = LoginViewModel(MockGithubAPI(completion: mockCompletion))
        viewModel.completion(URL(string: "https://www.apple.com/")!)
    }
}
