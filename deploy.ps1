# Deploy changes in JavaScript to docs
lein clean
lein fig:deploy

# Copy changes in css, images and index.html to docs
Copy-Item .\resources\public\css -r .\docs
Copy-Item .\resources\public\images -r images
Copy-Item .\resources\public\index.html .\docs

# Finish message
Write-Output "All done!"
