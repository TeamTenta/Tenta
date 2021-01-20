//
//  LoginView.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/18.
//

import SwiftUI

struct LoginView: View {
    var body: some View {
        VStack {
            Spacer()
            Text("Tenta")
                .font(.largeTitle)
                .bold()

            Spacer()

            GithubLoginButton()
                .aspectRatio(10, contentMode: .fit)
                .padding([.leading, .trailing], 30)
                .padding([.top, .bottom], 20)
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
