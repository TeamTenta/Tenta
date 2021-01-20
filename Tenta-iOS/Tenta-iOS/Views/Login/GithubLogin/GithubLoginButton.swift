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
                GithubLogoImage()
            } else {
                GithubLogoImage()
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
}

struct GithubLoginButton_Previews: PreviewProvider {
    static var previews: some View {
        let viewModel = LoginViewModel()

        GithubLoginButton(url: viewModel.githubLoginURL, completion: viewModel.githubLoginCompletion)
            .frame(width: 300, height: 50)
            .environment(\.colorScheme, .dark)
    }
}
