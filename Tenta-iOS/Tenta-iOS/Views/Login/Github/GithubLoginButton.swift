//
//  GithubLoginButton.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/18.
//

import SwiftUI

struct GithubLoginButton: View {
    @Environment(\.colorScheme) var colorScheme

    private let loginURL: URL?
    private let completion: (URL) -> Void

    init(url: URL?, completion: @escaping (URL) -> Void) {
        self.loginURL = url
        self.completion = completion
    }

    var body: some View {
        if let url = loginURL {
            Link(destination: url) {
                frameBody
            }
            .onOpenURL(perform: completion)
        } else {
            frameBody
        }
    }

    private var frameBody: some View {
        HStack {
            Spacer()

            if colorScheme == .light {
                icon
            } else {
                icon
                    .colorInvert()
            }

            Text("Sign in with Github")
                .font(.headline)
                .foregroundColor(Color("ReverseBackground"))
                .padding()

            Spacer()
        }
        .padding([.leading, .trailing])
        .background(Color("Background"))
        .cornerRadius(15)
        .overlay(
            RoundedRectangle(cornerRadius: 15)
                .stroke(Color("ReverseBackground"), lineWidth: 2)
        )
    }

    private var icon: some View {
        Image("github_icon")
            .resizable()
            .aspectRatio(contentMode: .fit)
            .cornerRadius(20)
            .padding(10)
    }
}

struct GithubLoginButton_Previews: PreviewProvider {
    static var previews: some View {
        let viewModel = LoginViewModel(ModelData().githubAPI)

        ForEach(ColorScheme.allCases, id: \.self) { color in
            GithubLoginButton(url: viewModel.url, completion: viewModel.completion)
                .frame(width: 300, height: 50)
                .preferredColorScheme(color)
        }
    }
}
