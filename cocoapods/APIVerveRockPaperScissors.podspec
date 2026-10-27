Pod::Spec.new do |s|
  s.name             = 'APIVerveRockPaperScissors'
  s.version          = '1.2.3'
  s.summary          = 'Rock Paper Scissors API simulates the classic hand game with detailed outcome analysis, statistics, and support for multiple rounds.'
  s.description      = <<-'DESC'
Rock Paper Scissors API simulates the classic hand game with detailed outcome analysis, statistics, and support for multiple rounds.

This iOS/macOS SDK provides a convenient way to access the Rock Paper Scissors from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/rockpaperscissors?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/rockpaperscissors-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveRockPaperScissors/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
