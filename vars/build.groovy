def call(String appName) {
  sh "docker build -t ${appName} ."
}