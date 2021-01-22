//
//  ModelData.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/20.
//

import Foundation

final class ModelData: ObservableObject {
    @Published var githubAPI = GithubAPIManager()
}
