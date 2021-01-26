//
//  ContentView.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/13.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var viewModel: ContentViewModel

    var body: some View {
        if viewModel.hasToken {
            MainView()
        } else {
            LoginView()
                .environmentObject(viewModel.loginViewModel)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    let gitnubAPI = GithubAPIManager()

    static var previews: some View {
        ContentView()
            .environmentObject(ContentViewModel(GithubAPIManager()))
    }
}
