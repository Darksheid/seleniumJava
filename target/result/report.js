$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/user_story.feature");
formatter.feature({
  "name": "Navigate to Google page",
  "description": "  This feature will help in automating Google Page navigation",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Open Google homepage",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@testRun"
    }
  ]
});
formatter.step({
  "name": "user tests download",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Test"
      ]
    },
    {
      "cells": [
        "TC01"
      ]
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "print running background steps",
  "keyword": "Given "
});
formatter.match({
  "location": "steps.print_back_run()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "check print of background steps",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.check_print_of_background_steps()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Open Google homepage",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@testRun"
    }
  ]
});
formatter.step({
  "name": "user tests download",
  "keyword": "Then "
});
formatter.match({
  "location": "steps.test_download()"
});
formatter.result({
  "status": "passed"
});
});