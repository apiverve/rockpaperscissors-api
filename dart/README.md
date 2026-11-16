# Rock Paper Scissors API - Dart/Flutter Client

Rock Paper Scissors API simulates the classic hand game with detailed outcome analysis, statistics, and support for multiple rounds.

[![pub package](https://img.shields.io/pub/v/apiverve_rockpaperscissors.svg)](https://pub.dev/packages/apiverve_rockpaperscissors)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Rock Paper Scissors API](https://apiverve.com/marketplace/rockpaperscissors?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_rockpaperscissors: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_rockpaperscissors/apiverve_rockpaperscissors.dart';

void main() async {
  final client = RockpaperscissorsClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'choice': 'random',
      'rounds': 1
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Rock Paper Scissors API](https://apiverve.com/marketplace/rockpaperscissors?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/rockpaperscissors](https://docs.apiverve.com/ref/rockpaperscissors?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
