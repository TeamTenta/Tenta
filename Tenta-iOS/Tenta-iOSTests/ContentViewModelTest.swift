//
//  ContentViewModelTest.swift
//  Tenta-iOSTests
//
//  Created by 김석호 on 2021/01/23.
//

import XCTest
@testable import Tenta_iOS

class ContentViewModelTest: XCTestCase {
    private var githubAPI: MockGithubAPI?
    private var viewModel: ContentViewModel?

    override func setUpWithError() throws {
        let mockCompletion: (URL) -> Void = { _ in }
        let api = MockGithubAPI(completion: mockCompletion)
        githubAPI = api
        viewModel = ContentViewModel(api)
    }

    func test_hasToken_true() throws {
        XCTAssertFalse(viewModel!.hasToken)
    }

    func test_hasToken_false() throws {
        githubAPI!.token = "test"
        XCTAssertTrue(viewModel!.hasToken)
    }
}
