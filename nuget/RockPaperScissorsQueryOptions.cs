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
        /// Your choice - omit for random
        /// </summary>
        [JsonProperty("choice")]
        public string Choice { get; set; }

        /// <summary>
        /// Number of rounds to play
        /// </summary>
        [JsonProperty("rounds")]
        public string Rounds { get; set; }
    }
}
