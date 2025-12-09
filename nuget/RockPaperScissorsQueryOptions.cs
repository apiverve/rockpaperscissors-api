using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.RockPaperScissors
{
    /// <summary>
    /// Query options for the Rock Paper Scissors API
    /// </summary>
    public class RockPaperScissorsQueryOptions
    {
        /// <summary>
        /// Your choice (rock, paper, scissors, r, p, s) - omit for random
        /// Example: rock
        /// </summary>
        [JsonProperty("choice")]
        public string Choice { get; set; }

        /// <summary>
        /// Number of rounds to play (1-100)
        /// Example: 5
        /// </summary>
        [JsonProperty("rounds")]
        public string Rounds { get; set; }
    }
}
