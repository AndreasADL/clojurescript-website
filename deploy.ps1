# Deploy changes in JavaScript to docs
lein clean
lein fig:deploy

# Copy changes in css, images and index.html to docs
Remove-Item -r .\docs\css
Copy-Item -r .\resources\public\css .\docs
Remove-Item -r .\docs\images
Copy-Item -r .\resources\public\images .\docs
Copy-Item .\resources\public\index.html .\docs

# Finish message
Write-Output "All done!"
