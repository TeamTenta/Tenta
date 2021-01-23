//
//  ContentViewModelTest.swift
//  Tenta-iOSTests
//
//  Created by 김석호 on 2021/01/23.
//

import XCTest
@testable import Tenta_iOS

class ContentViewModelTest: XCTestCase {
    private let githubAPI = MockGithubAPI()
    private var viewModel: ContentViewModel?

    override func setUpWithError() throws {
        viewModel = ContentViewModel(githubAPI)
    }

    // MARK: hasToken
    func test_hasToken_true() throws {
        XCTAssertFalse(viewModel!.hasToken)
    }

    func test_hasToken_false() throws {
        githubAPI.token = "test"
        XCTAssertTrue(viewModel!.hasToken)
    }
}
