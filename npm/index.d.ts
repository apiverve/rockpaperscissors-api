declare module '@apiverve/rockpaperscissors' {
  export interface rockpaperscissorsOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface rockpaperscissorsResponse {
    status: string;
    error: string | null;
    data: RockPaperScissorsData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface RockPaperScissorsData {
      totalRounds:      number | null;
      playerChoiceMode: null | string;
      games:            Game[];
      results:          Results;
      overallWinner:    null | string;
      gameRules:        GameRules;
  }
  
  interface GameRules {
      rockBeats:     null | string;
      paperBeats:    null | string;
      scissorsBeats: null | string;
  }
  
  interface Game {
      round:          number | null;
      playerChoice:   null | string;
      playerEmoji:    null | string;
      computerChoice: null | string;
      computerEmoji:  null | string;
      outcome:        null | string;
      message:        null | string;
  }
  
  interface Results {
      playerWINS:            number | null;
      computerWINS:          number | null;
      ties:                  number | null;
      playerWinPercentage:   number | null;
      computerWinPercentage: number | null;
      tiePercentage:         number | null;
  }

  export default class rockpaperscissorsWrapper {
    constructor(options: rockpaperscissorsOptions);

    execute(callback: (error: any, data: rockpaperscissorsResponse | null) => void): Promise<rockpaperscissorsResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: rockpaperscissorsResponse | null) => void): Promise<rockpaperscissorsResponse>;
    execute(query?: Record<string, any>): Promise<rockpaperscissorsResponse>;
  }
}
