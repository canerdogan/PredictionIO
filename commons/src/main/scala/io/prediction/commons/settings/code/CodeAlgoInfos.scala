package io.prediction.commons.settings.code

import io.prediction.commons.settings.{AlgoInfo, AlgoInfos}

/** Scala implementation of AlgoInfos. */
class CodeAlgoInfos extends AlgoInfos {
  private val wipAlgoInfos = Map(
    "pdio-knnitembased" -> AlgoInfo(
      id = "pdio-knnitembased",
      name = "kNN Item Based Collaborative Filtering",
      description = Some("This item-based k-NearestNeighbor algorithm predicts user preferences based on previous behaviors of users on similar items."),
      batchcommands = Some(Seq(
        "hadoop jar $jar$ io.prediction.algorithms.scalding.itemrec.knnitembased.DataPreparator --hdfs --dbType $appdataDbType$ --dbName $appdataDbName$ --dbHost $appdataDbHost$ --dbPort $appdataDbPort$ --hdfsRoot $hdfsRoot$ --appid $appid$ --engineid $engineid$ --algoid $algoid$ $itypes$ --viewParam $viewParam$ --likeParam $likeParam$ --dislikeParam $dislikeParam$ --conversionParam $conversionParam$ --conflictParam $conflictParam$",
        "hadoop jar $jar$ io.prediction.algorithms.scalding.itemrec.knnitembased.KNNItemBased --hdfs --hdfsRoot $hdfsRoot$ --appid $appid$ --engineid $engineid$ --algoid $algoid$ --measureParam $measureParam$ --priorCountParam $priorCountParam$ --priorCorrelParam $priorCorrelParam$ --minNumRatersParam $minNumRatersParam$ --maxNumRatersParam $maxNumRatersParam$ --minIntersectionParam $minIntersectionParam$ --minNumRatedSimParam $minNumRatedSimParam$",
        "hadoop jar $jar$ io.prediction.algorithms.scalding.itemrec.knnitembased.ModelConstructor --hdfs --dbType $modeldataDbType$ --dbName $modeldataDbName$ --dbHost $modeldataDbHost$ --dbPort $modeldataDbPort$ --hdfsRoot $hdfsRoot$ --appid $appid$ --engineid $engineid$ --algoid $algoid$ --modelSet $modelset$")),
      offlineevalcommands = Some(Seq(
        "hadoop jar $jar$ io.prediction.algorithms.scalding.itemrec.knnitembased.DataPreparator --hdfs --dbType $appdataTrainingDbType$ --dbName $appdataTrainingDbName$ --dbHost $appdataTrainingDbHost$ --dbPort $appdataTrainingDbPort$ --hdfsRoot $hdfsRoot$ --appid $appid$ --engineid $engineid$ --algoid $algoid$ --evalid $evalid$ $itypes$ --viewParam $viewParam$ --likeParam $likeParam$ --dislikeParam $dislikeParam$ --conversionParam $conversionParam$ --conflictParam $conflictParam$",
        "hadoop jar $jar$ io.prediction.algorithms.scalding.itemrec.knnitembased.KNNItemBased --hdfs --hdfsRoot $hdfsRoot$ --appid $appid$ --engineid $engineid$ --algoid $algoid$ --evalid $evalid$ --measureParam $measureParam$ --priorCountParam $priorCountParam$ --priorCorrelParam $priorCorrelParam$ --minNumRatersParam $minNumRatersParam$ --maxNumRatersParam $maxNumRatersParam$ --minIntersectionParam $minIntersectionParam$ --minNumRatedSimParam $minNumRatedSimParam$",
        "hadoop jar $jar$ io.prediction.algorithms.scalding.itemrec.knnitembased.ModelConstructor --hdfs --dbType $modeldataDbType$ --dbName $modeldataDbName$ --dbHost $modeldataDbHost$ --dbPort $modeldataDbPort$ --hdfsRoot $hdfsRoot$ --appid $appid$ --engineid $engineid$ --algoid $algoid$ --evalid $evalid$ --modelSet false")),
      paramdefaults = Map(
        "measureParam" -> "correl",
        "priorCountParam" -> 20,
        "priorCorrelParam" -> 0,
        "minNumRatersParam" -> 1,
        "maxNumRatersParam" -> 10000,
        "minIntersectionParam" -> 1,
        "minNumRatedSimParam" -> 1,
        "viewParam" -> 3,
        "viewmoreParam" -> 3,
        "likeParam" -> 5,
        "dislikeParam" -> 1,
        "conversionParam" -> 4,
        "conflictParam" -> "latest"), // latest, highest, lowest
      paramdescription = Map(
        "measureParam" -> ("Distance Function", ""),
        "priorCountParam" -> ("Virtual Count", "Suggested range: 0 to 100."),
        "priorCorrelParam" -> ("Prior Correlation", ""),
        "minNumRatersParam" -> ("Minimum Number of Raters", ""),
        "maxNumRatersParam" -> ("Maximum Number of Raters", ""),
        "minIntersectionParam" -> ("Minimum Intersection", ""),
        "minNumRatedSimParam" -> ("Minimum Number of Rated Similar Items", ""),
        "viewParam" -> ("View Score", ""),
        "viewmoreParam" -> ("View More Score", ""),
        "likeParam" -> ("Like Score", ""),
        "dislikeParam" -> ("Dislike Score", ""),
        "conversionParam" -> ("Buy Score", ""),
        "conflictParam" -> ("Override", "")),
      paramorder = Seq(
        "measureParam",
        "priorCountParam",
        "priorCorrelParam",
        "minNumRatersParam",
        "maxNumRatersParam",
        "minIntersectionParam",
        "minNumRatedSimParam",
        "viewParam",
        //"viewmoreParam", // not visible for now
        "likeParam",
        "dislikeParam",
        "conversionParam",
        "conflictParam"),
      enginetype = "itemrec",
      techreq = Seq("Hadoop"),
      datareq = Seq("U2I Actions such as Like, Buy and Rate.")
    ),
    "mahout-itembased" -> AlgoInfo(
      id = "mahout-itembased",
      name = "Mahout's Item Based Recommendation",
      description = Some("Predicts user preferences based on previous behaviors of users on similar items."),
      batchcommands = Some(Seq("TODO")),
      offlineevalcommands = Some(Seq("TODO")),
      paramdefaults = Map(
        "similarityClassname" -> "SIMILARITY_COOCCURRENCE",
        "viewParam" -> 3,
        "viewmoreParam" -> 3,
        "likeParam" -> 5,
        "dislikeParam" -> 1,
        "conversionParam" -> 4,
        "conflictParam" -> "latest"), // latest, highest, lowest
      paramdescription = Map(
        "similarityClassname" -> ("Distance Function", ""),
        "viewParam" -> ("View Score", ""),
        "viewmoreParam" -> ("View More Score", ""),
        "likeParam" -> ("Like Score", ""),
        "dislikeParam" -> ("Dislike Score", ""),
        "conversionParam" -> ("Buy Score", ""),
        "conflictParam" -> ("Override", "")),
      paramorder = Seq(
        "similarityClassname",
        "viewParam",
        //"viewmoreParam", // not visible for now
        "likeParam",
        "dislikeParam",
        "conversionParam",
        "conflictParam"),
      enginetype = "itemrec",
      techreq = Seq("Hadoop"),
      datareq = Seq("U2I Actions such as Like, Buy and Rate.")
    ),
    "mahout-parallelals" -> AlgoInfo(
      id = "mahout-parallelals",
      name = "Mahout's Parallel ALS",
      description = Some("Predicts user preferences based on previous behaviors of users."),
      batchcommands = Some(Seq("TODO")),
      offlineevalcommands = Some(Seq("TODO")),
      paramdefaults = Map(
        "lambda" -> 0.03,
        "implicitFeedback" -> false,
        "alpha" -> 40,
        "numFeatures" -> 3,
        "numIterations" -> 5,
        "viewParam" -> 3,
        "viewmoreParam" -> 3,
        "likeParam" -> 5,
        "dislikeParam" -> 1,
        "conversionParam" -> 4,
        "conflictParam" -> "latest"), // latest, highest, lowest
      paramdescription = Map(
        "lambda" -> ("Lambda", "Regularization param to avoid overfitting."),
        "implicitFeedback" -> ("Implicit Feedback", "Whether data consists of implicit data."),
        "alpha" -> ("Alpha", "Confidence param (will be ignored if Implicit Feedback is false)."),
        "numFeatures" -> ("Num of Factorized Features", "Dimension of the factorized feature space."),
        "numIterations" -> ("Number of Iterations", "Number of training iteration."),
        "viewParam" -> ("View Score", ""),
        "viewmoreParam" -> ("View More Score", ""),
        "likeParam" -> ("Like Score", ""),
        "dislikeParam" -> ("Dislike Score", ""),
        "conversionParam" -> ("Buy Score", ""),
        "conflictParam" -> ("Override", "")),
      paramorder = Seq(
        "lambda",
        "implicitFeedback",
        "alpha",
        "numFeatures",
        "numIterations",
        "viewParam",
        //"viewmoreParam", // not visible for now
        "likeParam",
        "dislikeParam",
        "conversionParam",
        "conflictParam"),
      enginetype = "itemrec",
      techreq = Seq("Hadoop"),
      datareq = Seq("U2I Actions such as Like, Buy and Rate.")
    ),
    "pdio-randomrank" -> AlgoInfo(
      id = "pdio-randomrank",
      name = "Random Rank",
      description = Some("Predict user preferences randomly."),
      batchcommands = Some(Seq("TODO")),
      offlineevalcommands = Some(Seq("TODO")),
      paramdefaults = Map(),
      paramdescription = Map(),
      paramorder = Seq(),
      enginetype = "itemrec",
      techreq = Seq("Hadoop"),
      datareq = Seq("Users and Items.")
    ),
    "pdio-latestrank" -> AlgoInfo(
      id = "pdio-latestrank",
      name = "Latest Rank",
      description = Some("Recommend latest items to users."),
      batchcommands = Some(Seq("TODO")),
      offlineevalcommands = Some(Seq("TODO")),
      paramdefaults = Map(),
      paramdescription = Map(),
      paramorder = Seq(),
      enginetype = "itemrec",
      techreq = Seq("Hadoop"),
      datareq = Seq("Users and Items with starttime.")
    )
  )

  /** Temporarily add alias before generalization is finished. */
  private val algoInfos = wipAlgoInfos ++ Map("io.prediction.algorithms.scalding.itemrec.knnitembased" -> wipAlgoInfos("pdio-knnitembased"))

  private val engineTypeToAlgoInfos = Map("itemrec" -> Seq("pdio-knnitembased", "mahout-itembased", "mahout-parallelals", "pdio-randomrank", "pdio-latestrank"))

  def get(id: String) = {
    algoInfos.get(id)
  }

  def getByEngineType(enginetype: String) = {
    engineTypeToAlgoInfos.getOrElse(enginetype, Seq()).map(algoInfos(_))
  }
}
