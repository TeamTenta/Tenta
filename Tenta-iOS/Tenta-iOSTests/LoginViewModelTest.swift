//
//  LoginViewModelTest.swift
//  Tenta-iOSTests
//
//  Created by 김석호 on 2021/01/23.
//

import XCTest
@testable import Tenta_iOS

class LoginViewModelTest: XCTestCase {
    // MARK: url
    func test_url_is_nil() {
        let api = MockGithubAPI()
        let viewModel = LoginViewModel(api)
        XCTAssertNotNil(viewModel.url)
    }

    func test_url_is_not_nil() {
        let api = MockGithubAPI()
        api.githubLoginURL = nil
        let viewModel = LoginViewModel(api)
        XCTAssertNil(viewModel.url)
    }

    // MARK: completion
    func test_githubLoginCompletion() {
        let exp = XCTestExpectation(description: "test completion")
        defer { wait(for: [exp], timeout: 5) }

        let mockCompletion: (URL) -> Void = { _ in
            exp.fulfill()
        }

        let viewModel = LoginViewModel(MockGithubAPI(completion: mockCompletion))
        viewModel.completion(URL(string: "https://www.apple.com/")!)
    }
}
