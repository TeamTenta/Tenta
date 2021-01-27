//
//  TentaApp.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/13.
//

import SwiftUI

@main
struct TentaApp: App {
    @StateObject var contentViewModel = ContentViewModel(GithubAPIManager())

    var body: some Scene {
        WindowGroup {
            ContentView()
                .environmentObject(contentViewModel)
        }
    }

}
