Feature: Display the tax details of cars

  Scenario: List the tax details of the cars using their registration number
    Given Euan decides to check the tax details of the cars with registration numbers present in a file under the path input.file.path
    Then he should see the car tax details matches the expected details from the output file under the path output.file.path


#1. Reads given input file: car_input.txt
#2. Extracts vehicle registration numbers based on pattern(s).
#3. Each number extracted from input file is fed to https://cartaxcheck.co.uk/
#(Peform Free Car Check)
#4. Compare the output returned by https://cartaxcheck.co.uk/ with given
#car_output.txt
#5. Highlight/fail the test for any mismatches.

#  Actor
#    Abilities:
#      Reads input and output files
#    Tasks:
#      Read registration number from a text file
#      Input these registration number to cartaxcheck
#      Read the card details for each registration number from the output text file
#      compare the details match
#      if they don't match, fail the test with error messages


