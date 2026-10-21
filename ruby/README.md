# Rock Paper Scissors API - Ruby Gem

Rock Paper Scissors API simulates the classic hand game with detailed outcome analysis, statistics, and support for multiple rounds.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_rockpaperscissors'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_rockpaperscissors
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_rockpaperscissors'

# Initialize the client
client = APIVerve::Rockpaperscissors::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  choice: "random",
  rounds: 1
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ choice: "random", rounds: 1 })
  puts response["data"]
rescue APIVerve::Rockpaperscissors::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Rockpaperscissors::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Rockpaperscissors::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "total_rounds": 5,
    "player_choice_mode": "manual",
    "games": [
      {
        "round": 1,
        "player_choice": "rock",
        "player_emoji": "🪨",
        "computer_choice": "paper",
        "computer_emoji": "📄",
        "outcome": "computer",
        "message": "Computer wins! undefined"
      },
      {
        "round": 2,
        "player_choice": "rock",
        "player_emoji": "🪨",
        "computer_choice": "rock",
        "computer_emoji": "🪨",
        "outcome": "tie",
        "message": "It's a tie! Both chose rock"
      },
      {
        "round": 3,
        "player_choice": "rock",
        "player_emoji": "🪨",
        "computer_choice": "rock",
        "computer_emoji": "🪨",
        "outcome": "tie",
        "message": "It's a tie! Both chose rock"
      },
      {
        "round": 4,
        "player_choice": "rock",
        "player_emoji": "🪨",
        "computer_choice": "paper",
        "computer_emoji": "📄",
        "outcome": "computer",
        "message": "Computer wins! undefined"
      },
      {
        "round": 5,
        "player_choice": "rock",
        "player_emoji": "🪨",
        "computer_choice": "scissors",
        "computer_emoji": "✂️",
        "outcome": "player",
        "message": "You win! Rock crushes scissors"
      }
    ],
    "results": {
      "player_wins": 1,
      "computer_wins": 2,
      "ties": 2,
      "player_win_percentage": 20,
      "computer_win_percentage": 40,
      "tie_percentage": 40
    },
    "overall_winner": "computer",
    "game_rules": {
      "rock_beats": "scissors",
      "paper_beats": "rock",
      "scissors_beats": "paper"
    }
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/rockpaperscissors?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/rockpaperscissors?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/rockpaperscissors?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
