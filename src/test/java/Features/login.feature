Feature: IssueWire login feature

Scenario Outline: IssueWire login Test scenario

Given user is already on front page
When title of front page is IssueWire
Then click to the login button
Then user enters "<username>" and "<password>"
And user clicks on login button
Then click to the add credit button
And new window will be open
Then dropdown will do select
Then return to the home page

Examples:
    | username | password |
    | pijus@elphilltechnology.com | Pijus2105@ |