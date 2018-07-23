SELECT C1.code, C2.code
FROM rCourse C1, rCrossListing, rCourse C2
WHERE C1.ID = rCrossListing.courseID1
  AND rCrossListing.courseID2 = C2.ID;




