$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/todos.feature");
formatter.feature({
  "name": "Manage todo list as a todoMVC user",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on todoMVC landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "TodoSteps.redirect_ToLandingPage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Add and remove items from todo list",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@P1"
    }
  ]
});
formatter.step({
  "name": "I add following items in todo list:",
  "rows": [
    {
      "cells": [
        "Lunch"
      ]
    },
    {
      "cells": [
        "Grocery"
      ]
    },
    {
      "cells": [
        "Laundry"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TodoSteps.addItems_ToList(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect \"3\" items added in the todo list",
  "keyword": "Then "
});
formatter.match({
  "location": "TodoSteps.verify_ItemsInList(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I remove following items from todo list",
  "rows": [
    {
      "cells": [
        "Laundry"
      ]
    },
    {
      "cells": [
        "Lunch"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "TodoSteps.removeItems_FromList(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I expect \"1\" items added in the todo list",
  "keyword": "Then "
});
formatter.match({
  "location": "TodoSteps.verify_ItemsInList(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});