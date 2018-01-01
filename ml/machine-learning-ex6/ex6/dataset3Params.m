function [C, sigma] = dataset3Params(X, y, Xval, yval)
%DATASET3PARAMS returns your choice of C and sigma for Part 3 of the exercise
%where you select the optimal (C, sigma) learning parameters to use for SVM
%with RBF kernel
%   [C, sigma] = DATASET3PARAMS(X, y, Xval, yval) returns your choice of C and 
%   sigma. You should complete this function to return the optimal C and 
%   sigma based on a cross-validation set.
%

% You need to return the following variables correctly.
C = 0.3;
sigma = 0.1;

% ====================== YOUR CODE HERE ======================
% Instructions: Fill in this function to return the optimal C and sigma
%               learning parameters found using the cross validation set.
%               You can use svmPredict to predict the labels on the cross
%               validation set. For example, 
%                   predictions = svmPredict(model, Xval);
%               will return the predictions on the cross validation set.
%
%  Note: You can compute the prediction error using 
%        mean(double(predictions ~= yval))
%

%CSet = [0.01, 0.03, 0.1, 0.3, 1, 3, 10, 30];
%sigmaSet = [0.01, 0.03, 0.1, 0.3, 1, 3, 10, 30];
%
%err = 1;
%ii = 0;
%jj = 0;
%for i = 1:length(CSet)
%    for j = 1:length(sigmaSet)
%        model= svmTrain(X, y, CSet(i), @(x1, x2) gaussianKernel(x1, x2, sigmaSet(i)));
%        predictions = svmPredict(model, Xval);
%        tmp = mean(double(predictions ~= yval));
%        if tmp < err
%            err = tmp;
%            ii = i;
%            jj = j;
%        end
%        fprintf('C: %f, sigma: %f, err:%f \n', CSet(i), sigmaSet(j), tmp);
%    end
%end
%
%CSet(ii)
%sigmaSet(jj)
%err



% =========================================================================

end
