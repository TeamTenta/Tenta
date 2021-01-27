//
//  GithubAPIManagerTest.swift
//  Tenta-iOSTests
//
//  Created by 김석호 on 2021/01/23.
//

import XCTest
import Combine
@testable import Tenta_iOS

class GithubAPIManagerTest: XCTestCase {
    private var cancellables = Set<AnyCancellable>()

    // MARK: token
    func test_publish_when_changing_token() throws {
        let api = GithubAPIManager()
        let testToken = "test"
        let exp = XCTestExpectation(description: "test token")
        var isFirst = true

        defer { wait(for: [exp], timeout: 5) }

        api.$token
            .sink { token in
                if isFirst {
                    XCTAssertNil(token)
                    isFirst = false
                } else {
                    XCTAssertEqual(token, testToken)
                    exp.fulfill()
                }
            }
            .store(in: &cancellables)

        api.token = testToken
    }

    // MARK: githubLoginURL
    func test_githubLoginURL() {
        let api = GithubAPIManager()
        XCTAssertNotNil(api.githubLoginURL)
    }

    // MARK: githubLoginCompletion
    func test_githubLoginCompletion_when_correct_url() {
        let api = GithubAPIManager()
        let testToken = "test"
        let testURL = URL(string: "tenta://\(testToken)")!

        api.githubLoginCompletion(testURL)
        XCTAssertEqual(api.token, testToken)
    }

    func test_githubLoginCompletion_when_incorrect_url() {
        let api = GithubAPIManager()
        let testURL = URL(string: "https://www.apple.com/")!

        api.githubLoginCompletion(testURL)
        XCTAssertNil(api.token)
    }
}
