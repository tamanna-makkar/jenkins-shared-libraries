def call(String credId, String appName, String imageName) {
    withCredentials([usernamePassword(
        credentialsId: credId,
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUsername'
    )]) {
            sh "docker login -u ${env.dockerHubUsername} -p ${env.dockerHubPass}"
            sh "docker image tag ${appName} ${env.dockerHubUsername}/${imageName}:main"
            sh "docker push ${env.dockerHubUsername}/${imageName}:main"
        }
}