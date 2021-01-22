//
//  ContentView.swift
//  Tenta-iOS
//
//  Created by 김석호 on 2021/01/13.
//

import SwiftUI

struct ContentView: View {
    @EnvironmentObject var modelData: ModelData
    
    var body: some View {
        LoginView(viewModel: LoginViewModel(modelData.githubAPI))
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
            .environmentObject(ModelData())
    }
}
