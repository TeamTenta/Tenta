//
//  GithubLoginButton.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/18.
//

import SwiftUI

struct GithubLogoImage: View {
    var body: some View {
        Image("github_icon")
            .resizable()
            .aspectRatio(contentMode: .fit)
            .cornerRadius(20)
            .padding(10)
    }
}

struct GithubLoginButton: View {
    @Environment(\.colorScheme) var colorScheme
    @StateObject var viewModel = GithubLoginViewModel()

    var body: some View {
        Link(destination: viewModel.githubLoginURL!) {
            frameBody
        }
        .onOpenURL(perform: { url in
            viewModel.receive(url: url)
        })
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
        GithubLoginButton()
            .frame(width: 300, height: 50)
            .environment(\.colorScheme, .dark)
            .environmentObject(ModelData())
    }
}
