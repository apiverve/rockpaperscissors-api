Rock Paper Scissors API
============

Rock Paper Scissors API simulates the classic hand game with detailed outcome analysis, statistics, and support for multiple rounds.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Rock Paper Scissors API](https://apiverve.com/marketplace/api/rockpaperscissors)

---

## Installation
	pip install apiverve-rockpaperscissors

---

## Configuration

Before using the rockpaperscissors API client, you have to setup your account and obtain your API Key.  
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Usage

The Rock Paper Scissors API documentation is found here: [https://docs.apiverve.com/api/rockpaperscissors](https://docs.apiverve.com/api/rockpaperscissors).  
You can find parameters, example responses, and status codes documented here.

### Setup

```
# Import the client module
from apiverve_rockpaperscissors.apiClient import RockpaperscissorsAPIClient

# Initialize the client with your APIVerve API key
api = RockpaperscissorsAPIClient("[YOUR_API_KEY]")
```

---


### Perform Request
Using the API client, you can perform requests to the API.

###### Define Query

```
query = { "choice": "rock", "rounds": 5 }
```

###### Simple Request

```
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

```
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
        "computer_choice": "paper",
        "computer_emoji": "📄",
        "outcome": "computer",
        "message": "Computer wins! undefined"
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
        "computer_choice": "scissors",
        "computer_emoji": "✂️",
        "outcome": "player",
        "message": "You win! Rock crushes scissors"
      },
      {
        "round": 5,
        "player_choice": "rock",
        "player_emoji": "🪨",
        "computer_choice": "paper",
        "computer_emoji": "📄",
        "outcome": "computer",
        "message": "Computer wins! undefined"
      }
    ],
    "results": {
      "player_wins": 1,
      "computer_wins": 3,
      "ties": 1,
      "player_win_percentage": 20,
      "computer_win_percentage": 60,
      "tie_percentage": 20
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

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.