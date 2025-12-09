declare module '@apiverve/rockpaperscissors' {
  export interface rockpaperscissorsOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface rockpaperscissorsResponse {
    status: string;
    error: string | null;
    data: RockPaperScissorsData;
    code?: number;
  }


  interface RockPaperScissorsData {
      totalRounds:      number;
      playerChoiceMode: string;
      games:            Game[];
      results:          Results;
      overallWinner:    string;
      gameRules:        GameRules;
  }
  
  interface GameRules {
      rockBeats:     string;
      paperBeats:    string;
      scissorsBeats: string;
  }
  
  interface Game {
      round:          number;
      playerChoice:   string;
      playerEmoji:    string;
      computerChoice: string;
      computerEmoji:  string;
      outcome:        string;
      message:        string;
  }
  
  interface Results {
      playerWINS:            number;
      computerWINS:          number;
      ties:                  number;
      playerWinPercentage:   number;
      computerWinPercentage: number;
      tiePercentage:         number;
  }

  export default class rockpaperscissorsWrapper {
    constructor(options: rockpaperscissorsOptions);

    execute(callback: (error: any, data: rockpaperscissorsResponse | null) => void): Promise<rockpaperscissorsResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: rockpaperscissorsResponse | null) => void): Promise<rockpaperscissorsResponse>;
    execute(query?: Record<string, any>): Promise<rockpaperscissorsResponse>;
  }
}
