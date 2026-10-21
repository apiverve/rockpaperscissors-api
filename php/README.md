# Rock Paper Scissors API - PHP Package

Rock Paper Scissors API simulates the classic hand game with detailed outcome analysis, statistics, and support for multiple rounds.

## Installation

Install via Composer:

```bash
composer require apiverve/rockpaperscissors
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Rockpaperscissors\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'choice' => 'random',
    'rounds' => 1
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Rockpaperscissors\Client;
use APIVerve\Rockpaperscissors\Exceptions\APIException;
use APIVerve\Rockpaperscissors\Exceptions\ValidationException;

try {
    $response = $client->execute(['choice' => 'random', 'rounds' => 1]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/rockpaperscissors?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/rockpaperscissors?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/rockpaperscissors?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
