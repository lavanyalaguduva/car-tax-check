Feature: Perform a free car check

  Scenario: Compare the tax details of the cars using the registration number from file 1
    Given Euan decides to check the tax details of the cars whose registration numbers present in a file under the path input.file.path
    Then he should see the displayed car tax details matches the expected details from the output file under the path output.file.path

  Scenario: Check the details of a car whose expected details are missing in the output file
    Given Netraa decides to check the tax details of the cars whose registration numbers present in a file under the path input.file2.path
    Then she should see the displayed car tax details matches the expected details from the output file under the path output.file2.path
