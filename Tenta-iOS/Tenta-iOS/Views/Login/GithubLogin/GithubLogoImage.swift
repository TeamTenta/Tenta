//
//  GithubLogoImage.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/19.
//

import SwiftUI

struct GithubLogoImage: View {
    @Environment(\.colorScheme) var colorScheme

    var body: some View {
        if colorScheme == .light {
            icon
        } else {
            icon
                .colorInvert()
        }
    }

    var icon: some View {
        Image("github_icon")
            .resizable()
            .aspectRatio(contentMode: .fit)
            .cornerRadius(20)
            .padding(10)
    }
}

struct GithubLogoImage_Previews: PreviewProvider {
    static var previews: some View {
        GithubLogoImage()
    }
}
