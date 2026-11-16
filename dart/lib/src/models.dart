/// Response models for the Rock Paper Scissors API.

/// API Response wrapper.
class RockpaperscissorsResponse {
  final String status;
  final dynamic error;
  final RockpaperscissorsData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  RockpaperscissorsResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory RockpaperscissorsResponse.fromJson(Map<String, dynamic> json) => RockpaperscissorsResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? RockpaperscissorsData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Rock Paper Scissors API.

class RockpaperscissorsData {
  num? totalRounds;
  String? playerChoiceMode;
  List<RockpaperscissorsDataGamesItem>? games;
  RockpaperscissorsDataResults? results;
  String? overallWinner;
  RockpaperscissorsDataGameRules? gameRules;

  RockpaperscissorsData({
    this.totalRounds,
    this.playerChoiceMode,
    this.games,
    this.results,
    this.overallWinner,
    this.gameRules,
  });

  factory RockpaperscissorsData.fromJson(Map<String, dynamic> json) => RockpaperscissorsData(
      totalRounds: json['total_rounds'],
      playerChoiceMode: json['player_choice_mode'],
      games: (json['games'] as List?)?.map((e) => RockpaperscissorsDataGamesItem.fromJson(e)).toList(),
      results: json['results'] != null ? RockpaperscissorsDataResults.fromJson(json['results']) : null,
      overallWinner: json['overall_winner'],
      gameRules: json['game_rules'] != null ? RockpaperscissorsDataGameRules.fromJson(json['game_rules']) : null,
    );
}

class RockpaperscissorsDataGamesItem {
  num? round;
  String? playerChoice;
  String? playerEmoji;
  String? computerChoice;
  String? computerEmoji;
  String? outcome;
  String? message;

  RockpaperscissorsDataGamesItem({
    this.round,
    this.playerChoice,
    this.playerEmoji,
    this.computerChoice,
    this.computerEmoji,
    this.outcome,
    this.message,
  });

  factory RockpaperscissorsDataGamesItem.fromJson(Map<String, dynamic> json) => RockpaperscissorsDataGamesItem(
      round: json['round'],
      playerChoice: json['player_choice'],
      playerEmoji: json['player_emoji'],
      computerChoice: json['computer_choice'],
      computerEmoji: json['computer_emoji'],
      outcome: json['outcome'],
      message: json['message'],
    );
}

class RockpaperscissorsDataResults {
  num? playerWins;
  num? computerWins;
  num? ties;
  num? playerWinPercentage;
  num? computerWinPercentage;
  num? tiePercentage;

  RockpaperscissorsDataResults({
    this.playerWins,
    this.computerWins,
    this.ties,
    this.playerWinPercentage,
    this.computerWinPercentage,
    this.tiePercentage,
  });

  factory RockpaperscissorsDataResults.fromJson(Map<String, dynamic> json) => RockpaperscissorsDataResults(
      playerWins: json['player_wins'],
      computerWins: json['computer_wins'],
      ties: json['ties'],
      playerWinPercentage: json['player_win_percentage'],
      computerWinPercentage: json['computer_win_percentage'],
      tiePercentage: json['tie_percentage'],
    );
}

class RockpaperscissorsDataGameRules {
  String? rockBeats;
  String? paperBeats;
  String? scissorsBeats;

  RockpaperscissorsDataGameRules({
    this.rockBeats,
    this.paperBeats,
    this.scissorsBeats,
  });

  factory RockpaperscissorsDataGameRules.fromJson(Map<String, dynamic> json) => RockpaperscissorsDataGameRules(
      rockBeats: json['rock_beats'],
      paperBeats: json['paper_beats'],
      scissorsBeats: json['scissors_beats'],
    );
}

class RockpaperscissorsRequest {
  String? choice;
  int? rounds;

  RockpaperscissorsRequest({
    this.choice,
    this.rounds,
  });

  Map<String, dynamic> toJson() => {
      if (choice != null) 'choice': choice,
      if (rounds != null) 'rounds': rounds,
    };
}
